"use client";

import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "@/components/Navbar";

export const metadata = {
  title: "Password Manager",
  description: "Password Manager",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body>
        <header>
          <Navbar />
        </header>

        {children}
      </body>
    </html>
  );
}
