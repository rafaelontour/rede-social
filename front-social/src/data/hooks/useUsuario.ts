"use client"

import { useContext } from "react"
import { ContextoUsuario } from "../context/ContextoUsuario"

const useUsuario = () => {
    const contexto = useContext(ContextoUsuario)

    if (!contexto) {
        throw new Error("useUsuario deve ser usado dentro de um ContextoUsuarioProvider");
    }

    return contexto
}

export default useUsuario;