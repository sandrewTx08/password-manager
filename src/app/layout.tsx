"use client";

import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "@/components/Navbar";
import UserProvider from "@/contexts/User";
import { useEffect, useState } from "react";

export const metadata = {
  title: "Password Manager",
  description: "Password Manager",
};

export default function RootLayout({ children }: React.PropsWithChildren) {
  const [state, stateSet] = useState(null);

  useEffect(() => {
    fetch("/userdetails", {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
    })
      .then((response) => response.json())
      .then(stateSet);
  }, []);

  return (
    <html lang="en">
      <body>
        <UserProvider state={[state, stateSet]}>
          <header>
            <Navbar />
          </header>

          {children}
        </UserProvider>
      </body>
    </html>
  );
}
