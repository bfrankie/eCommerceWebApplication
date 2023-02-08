import React, { useState, useEffect, useRef, useContext } from 'react'
import { CartContext } from '../CartComponents/CartContext'

function Paypal() {

  useEffect(()=>{
    localStorage.setItem('data',JSON.stringify(cartItems))
  })

    const [paid, setPaid] = useState(false);
    const [error, setError] = useState(null);
    const [cartItems, setCartItems] = useContext(CartContext);

    const paypalRef = useRef();


    // Calculate total cost to be charge to customer
    const totalCost = () => {
      const cost = () => {
        const sum = totals => totals.reduce((a, b) => a + b, 0);
        const totals = cartItems.map((item) => item.price * item.quantity);
        return (sum(totals));
      }

      const taxes = (cost() * .0625);
      const shipping = 5.99
      return (cost() + shipping + taxes)
    }

console.log(window.paypal)
    useEffect(() => {
        window.paypal
          .Buttons({
            createOrder: (data, actions) => {
              return actions.order.create({
                intent: "CAPTURE",
                purchase_units: [
                  {
                    description: "Sweet Water Decor Purchase Order",
                    amount: {
                      currency_code: "USD",
                      value: 500,
                    },
                  },
                ],
              });
            },
            onApprove: async (data, actions) => {
              const order = await actions.order.capture();
              setPaid(true);
              setCartItems([]);
            },
            onError: (err) => {
            //   setError(err),
              console.error(err);
            },
          })
          .render(paypalRef.current);
      }, []);

    // If the payment has been made
    if (paid) {
      return <div>Your payment was successful! You will recieve a confirmation email containing the details of your order, along with estimated shipping time(s).</div>;
    }

    // If any error occurs
    if (error) {
        return <div>Unable to process payment. Please try again.</div>;
    }

    return (
        <div>
            <div ref={paypalRef} />
        </div>
    )
}

export default Paypal
