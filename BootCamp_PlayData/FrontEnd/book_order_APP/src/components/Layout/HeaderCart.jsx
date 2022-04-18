import React from 'react'
import CartIcon from '../Cart/CartIcon'
import classes from './HeaderCart.module.css'

const HeaderCart = () => {
  return (
    <button className={classes.button}>
        <span className={classes.icon}><CartIcon /></span>
        <span>My Cart</span>
    </button>
  )
}

export default HeaderCart