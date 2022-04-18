import React from 'react'
import AddBookForm from './AddBookForm'
import classes from './Book.module.css'

const Book = (props) => {
  return (
    <li key={props.id} className={classes.book}>
        <div>
          <h3>{props.name}</h3>
          <div className={classes.description}>{props.description}</div>
          <div className={classes.price}>{props.price}</div>
        </div>
        <div> <AddBookForm/> </div>
    </li>
  )
}

export default Book