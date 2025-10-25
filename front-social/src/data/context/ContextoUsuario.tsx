"use client";

import { Usuario } from "@/core/constants/usuario";
import { createContext, ReactNode, useEffect, useState } from "react";

export interface UsuarioProps {
    usuario: Usuario
    logar: () => void
    deslogar: () => void
}

export const ContextoUsuario = createContext<UsuarioProps>({} as UsuarioProps);

export const ContextoUsuarioProvider = ({ children }: { children: ReactNode }) => {
    const [usuario, setUsuario] = useState<Usuario>({} as Usuario);

    const u: Usuario = {
        id: "123",
        username: "Alana",
        email: "alana@gmail.com",
        displayName: "Alana Abreu",
        bio: "Qualquer coisaa",
        avatarUrl: "...",
        createdAt: "Hoje"
    }

    const logar = () => {
        setUsuario({} as Usuario);
    }

    const deslogar = () => {
        setUsuario({} as Usuario);
    }

    useEffect(() => {
        setUsuario(u);
    }, [])

    return (
        <ContextoUsuario.Provider
            value={{
                usuario,
                logar,
                deslogar
            }}
        >
            {children}
        </ContextoUsuario.Provider>
    )
}