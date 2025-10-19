"use client";
import { useState } from "react";
import { Sidebar, SidebarBody, SidebarLink } from "./ui/sidebar";
import { Home, Users } from "lucide-react";

export default function BarraLateral() {
      const links = [
    {
      label: "Home",
      href: "#",
      icon: (
        <Home/>
      ),
    },
    {
      label: "Amigos",
      href: "#",
      icon: (
        <Users/>
      ),
    },
    {
      label: "Meus posts",
      href: "#",
      icon: (
        ""
      ),
    },
   
  ];
  const [open, setOpen] = useState(false);

    return (
        <Sidebar open={open} setOpen={setOpen} animate={true}>
            <SidebarBody className="justify-between gap-2">
                <div className="flex flex-1 flex-col overflow-x-hidden overflow-y-auto">
                    <>
                        <Logo />
                    </>
                    <div className="mt-8 flex flex-col gap-2">
                    {links.map((link, idx) => (
                        <SidebarLink key={idx} link={link} />
                    ))}
                    </div>
                </div>
                <div>
                    <SidebarLink
                    link={{
                        label: "Manu Arora",
                        href: "#",
                        icon: (
                        <img
                            src="https://assets.aceternity.com/manu.png"
                            className="h-7 w-7 shrink-0 rounded-full"
                            width={50}
                            height={50}
                            alt="Avatar"
                        />
                        ),
                    }}
                    />
                </div>
            </SidebarBody>
        </Sidebar>
    );
}

export const Logo = () => {
  return (
    <a
      href="#"
      className="relative z-20 flex items-center space-x-2 py-1 text-sm font-normal text-black"
    >
      <div className="h-5 w-6 shrink-0 rounded-tl-lg rounded-tr-sm rounded-br-lg rounded-bl-sm bg-black dark:bg-white" />
      
        <span className="px-2">MCN</span>
     
    </a>
  );
};