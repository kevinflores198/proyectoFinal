import React, { useEffect, useState } from 'react'
import { useUserForm } from '../../hooks/Custom.hooks'

const UserForm = () => {

  const { form, setForm, handleChanges } = useUserForm();

  const [areEquals, setAreEquals] = useState(true);
  const [passwordConfirmation, setPasswordConfirmation] = useState();


  const handlePasswordConfirmation = (e) => {
    setPasswordConfirmation(e.target.value);
  }

  useEffect(() => {
    const { password } = form;
    setAreEquals(password === passwordConfirmation);
  }, [passwordConfirmation])

  const handleSubmit = (e) => {
    e.preventDefault() //nos proteje de que no refresque la pagina
    // UserService.save(form);
    console.log(form);
  }

  return (
    <div className='formulario'>
      <form className='form'>

        <h2>Registro</h2>

        <div className="mb-3">
          <input
            type="email"
            id="disabledTextInput1"
            className="form-control"
            placeholder="Email"
            name='email'
            onChange={handleChanges}
          />
        </div>

        <div className="mb-3">
          <input
            type="password"
            id="disabledTextInput2"
            className="form-control"
            placeholder="contrasña"
            name='password'
            onChange={handleChanges}
          />
        </div>

        <div className="mb-3">
          <input
            type="text"
            id="disabledTextInput3"
            className="form-control"
            placeholder="Repetir contraseña"
            onChange={handlePasswordConfirmation}
          />
        </div>

        {!areEquals && (
          <div className='form-text list-group-item-danger'>
            Las claves no son iguales
          </div>
        )}

        <button
          disabled={!areEquals} //desabilita el boton hasta que las contraseñas sean iguales
          type="submit"
          className="btn btn-primary"
          onClick={handleSubmit}
        >
          Registrarme
        </button>
      </form>
    </div>
  )
}

export default UserForm
