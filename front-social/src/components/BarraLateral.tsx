"use client";
import { useState } from "react";
import { Sidebar, SidebarBody, SidebarLink } from "./ui/sidebar";
import { Home, Newspaper, Users } from "lucide-react";

const Logo = () => {
  return (
    <span className="px-2">MCN</span>
  );
};


export default function BarraLateral() {
    const links = [
    {
      label: "Home",
      href: "#",
      icon: (
        <Home color="white"/>
      ),
    },
    {
      label: "Amigos",
      href: "#",
      icon: (
        <Users color="white"/>
      ),
    },
    {
      label: "Meus posts",
      href: "#",
      icon: (
        <Newspaper color="white"/>
      ),
    },
   
  ];
  const [open, setOpen] = useState(false);

    return (
        <div className="border-r-16 border-violet-500">
          <Sidebar open={open} setOpen={setOpen} animate={true} >
              <SidebarBody className="justify-between gap-2">
                  <div className="flex flex-1 flex-col overflow-x-hidden overflow-y-auto">
                      <>
                          <Logo />
                      </>
                      <div className="mt-8 flex flex-col  gap-2 ">
                      {links.map((link, idx) => (
                          <div className="bg-violet-500 rounded-sm px-2  pl-3">
                            <SidebarLink key={idx} link={link} />
                          </div>
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
        </div>
    );
}

