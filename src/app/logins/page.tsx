"use client";

import { Context } from "@/contexts/Logins";
import { Tab, Row, Col, ListGroup, Form } from "react-bootstrap";
import { useDebounce } from "use-debounce";
import { useState, useEffect } from "react";

function CreateLogin({ data }: React.PropsWithChildren<{ data: any }>) {
  return <></>;
}

function LoginTabPane({ data }: React.PropsWithChildren<{ data: any }>) {
  const [login, loginSet] = useState(data);
  const [_login] = useDebounce(login, 1000);

  useEffect(() => {
    fetch(`/login/${_login._id}`, {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      method: "PATCH",
      body: JSON.stringify(_login),
    });
  }, [_login]);

  return (
    <Tab.Pane eventKey={data._id}>
      <Form.Control
        size="sm"
        name="domain"
        type="text"
        className="mb-3"
        placeholder="Website"
        value={login.domain}
        onChange={(event) => {
          loginSet((value) => {
            // @ts-ignore
            value.domain = event.target.value;
            return { ...value };
          });
        }}
      />
      <Form.Control
        size="sm"
        name="username"
        type="text"
        className="mb-3"
        placeholder="Username"
        value={login.username}
        onChange={(event) => {
          loginSet((value) => {
            // @ts-ignore
            value.username = event.target.value;
            return { ...value };
          });
        }}
      />
      <Form.Control
        size="sm"
        name="password"
        type="text"
        className="mb-3"
        placeholder="Password"
        value={login.password}
        onChange={(event) => {
          loginSet((value) => {
            // @ts-ignore
            value.password = event.target.value;
            return { ...value };
          });
        }}
      />
    </Tab.Pane>
  );
}

export default function RootLayout() {
  return (
    <Context.Consumer>
      {([state]) =>
        state ? (
          <Tab.Container id="list-group-tabs-example" defaultActiveKey="first">
            <Row>
              <Col sm={4}>
                <ListGroup>
                  {state.map((data) => (
                    <ListGroup.Item key={data._id} eventKey={data._id} action>
                      {data.domain}
                    </ListGroup.Item>
                  ))}
                </ListGroup>
              </Col>
              <Col sm={8}>
                <Tab.Content>
                  {state.map((data) => (
                    <LoginTabPane key={data._id} data={data} />
                  ))}
                </Tab.Content>
              </Col>
            </Row>
          </Tab.Container>
        ) : (
          <>Looading...</>
        )
      }
    </Context.Consumer>
  );
}
