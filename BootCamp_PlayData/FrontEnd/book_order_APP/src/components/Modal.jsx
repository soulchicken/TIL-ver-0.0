import React from 'react'
import ReactDOM from 'react-dom';
import classes from './Modal.module.css'

// Modal의 배경부분
const Background = props => {
    return <div className={classes.background} />
}

// Modal Window 부분

const ModalWindow = props => {
    return (
        <div className={classes.modal}>
            <div className={classes.content}>{props.children}</div>
        </div>
    )
}

const portalElement = document.getElementById('modal-window');

const Modal = props => {
  return (
    <>
        {ReactDOM.createPotal(<Background />, portalElement)}
        {ReactDOM.createPotal(<ModalWindow>{props.children}</ModalWindow>, portalElement)} 
    </>
  )
}

export default Modal