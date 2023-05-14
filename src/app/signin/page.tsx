"use client";

import axios from "axios";
import { useRouter } from "next/navigation";
import { useReducer } from "react";
import { Form, Button, Container, Alert } from "react-bootstrap";

export default function Page() {
  interface State {
    content: string;
    variant: string;
  }

  const router = useRouter();
  const [state, dispatch] = useReducer(
    (state: State, action: { payload: number }): State => {
      switch (action.payload) {
        case axios.HttpStatusCode.Unauthorized:
          return { content: "Invalid credentials", variant: "danger" };

        case axios.HttpStatusCode.Ok:
          router.push("/");
          return state;

        default:
          return { content: "Unexpected error", variant: "danger" };
      }
    },
    null
  );

  return (
    <Container className="mt-5 d-flex justify-content-center">
      <Form
        method="POST"
        onSubmit={(event) => {
          event.preventDefault();

          axios("/login", {
            auth: {
              password: (event.target as unknown as any).password.value,
              username: (event.target as unknown as any).username.value,
            },
          })
            .catch(({ response }) => response)
            .then(({ status }) => {
              dispatch({ payload: status });
            });
        }}
      >
        <Form.Group className="mb-3">
          <Form.Label>Email address</Form.Label>
          <Form.Control
            name="username"
            type="email"
            placeholder="Enter email"
          />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>Password</Form.Label>
          <Form.Control
            name="password"
            type="password"
            placeholder="Password"
          />
        </Form.Group>

        {state && <Alert variant={state.variant}>{state.content}</Alert>}

        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </Container>
  );
}
