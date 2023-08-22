import { useState } from "react"

//el json comienza vacio y a medida que pasa el codigo se va llenando
export const useUserForm = (initialState = {}) => {

    const [form, setForm] = useState(initialState)

    const handleChanges = ({ target }) => {

        const { name, value } = target;

        setForm(
            {
                //si formulario tenia valores, se deben setear
                ...form,
                [name]: value,
            })
    }

    return {
        form, setForm, handleChanges,
    }
}