import React from 'react'

const Modal = ({ text }) => {
  return (
    <div aria-hidden="true" className="modal" id="my-modal">
      <div className="modal-background close-modal" data-modal-id="#my-modal"></div>
      <div className="modal-content">{text}</div>
      <button
        aria-label="close"
        className="delete close-modal"
        data-modal-id="#my-modal"
        type="button"
      ></button>
    </div>
  )
}

export default Modal
