"use client";

import { Context } from "@/contexts/User";
import { useRouter } from "next/navigation";
import { useContext } from "react";
import { Navbar, Container, Nav, NavDropdown } from "react-bootstrap";
import { BsGithub } from "react-icons/bs";
import { FaUserCircle } from "react-icons/fa";
import { IoSettingsSharp } from "react-icons/io5";

export default function Component() {
  const router = useRouter();
  const [user] = useContext(Context);

  return (
    <Navbar bg="primary" variant="dark" expand="lg">
      <Container>
        <Navbar.Brand onClick={() => router.push("/")}>
          Password manager
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse>
          <Nav className="me-auto">
            {user ? (
              <>
                <Nav.Link onClick={() => router.push("/")}>Logins</Nav.Link>
                <NavDropdown title={user.email}>
                  <NavDropdown.Item
                    className="d-inline-flex justify-content-between align-items-center"
                    onClick={() => router.push("/settings/profile")}
                  >
                    Profile
                    <FaUserCircle />
                  </NavDropdown.Item>
                  <NavDropdown.Item
                    className="d-inline-flex justify-content-between align-items-center"
                    onClick={() => router.push("/settings")}
                  >
                    Settings
                    <IoSettingsSharp />
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item
                    onClick={() => (window.location.href = "/logout")}
                  >
                    Logout
                  </NavDropdown.Item>
                </NavDropdown>
              </>
            ) : (
              <>
                <Nav.Link onClick={() => router.push("/login")}>
                  Sign-in
                </Nav.Link>
              </>
            )}
            <Nav.Link
              className="d-block d-md-none"
              href="https://github.com/sandrewTx08/password-manager"
            >
              <BsGithub color="white" className="mx-2 align-items-center" />
              GitHub
            </Nav.Link>
            <Nav.Link
              className="d-none d-md-block"
              href="https://github.com/sandrewTx08/password-manager"
            >
              <BsGithub color="white" />
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
