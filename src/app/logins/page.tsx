"use client";

import { Context, Data } from "@/contexts/Logins";
import { Tab, Row, Col, ListGroup, Form, Button } from "react-bootstrap";
import { useDebounce } from "use-debounce";
import { useState, useEffect } from "react";
import {
  BsFillClipboard2Fill,
  BsFillPencilFill,
  BsGlobe2,
} from "react-icons/bs";

function CreateLogin({ data }: React.PropsWithChildren<{ data: Data }>) {
  return <></>;
}

function LoginTabPane({ data }: React.PropsWithChildren<{ data: Data }>) {
  const [loginData, loginSet] = useState(data);
  const [editing, editingSet] = useState(true);
  const [login] = useDebounce(loginData, 1000);

  useEffect(() => {
    fetch(`/login/${login._id}`, {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      method: "PATCH",
      body: JSON.stringify(login),
    });
  }, [login]);

  function onChange(event: React.ChangeEvent) {
    loginSet((value) => {
      // @ts-ignore
      value[event.target.name] = event.target.value;
      return { ...value };
    });
  }

  return (
    <Tab.Pane eventKey={data._id}>
      <h1 className="d-flex justify-content-between">
        <BsGlobe2 /> {loginData.domain}
        <div>
          <Button
            onClick={() => editingSet((value) => !value)}
            variant="outline-primary"
          >
            <BsFillPencilFill />
            Edit
          </Button>
        </div>
      </h1>

      <div>
        <Form.Control
          size="sm"
          name="username"
          type="text"
          disabled={editing}
          placeholder="Username"
          value={loginData.username}
          onChange={onChange}
        />
        <Button
          variant="primary"
          onClick={() => navigator.clipboard.writeText(loginData.username)}
        >
          <BsFillClipboard2Fill /> Copy
        </Button>
      </div>

      <div>
        <Form.Control
          size="sm"
          name="password"
          type="password"
          disabled={editing}
          placeholder="Password"
          value={loginData.password}
          onChange={onChange}
        />
        <Button
          variant="primary"
          onClick={() => navigator.clipboard.writeText(loginData.password)}
        >
          <BsFillClipboard2Fill /> Copy
        </Button>
      </div>
    </Tab.Pane>
  );
}

export default function RootLayout() {
  return (
    <Context.Consumer>
      {([state]) =>
        state ? (
          <Tab.Container
            id="list-group-tabs-example"
            defaultActiveKey={state[0]._id}
          >
            <Row>
              <Col md={4}>
                <ListGroup>
                  {state.map((data) => (
                    <ListGroup.Item
                      className="overflow-hidden"
                      key={data._id}
                      eventKey={data._id}
                      action
                    >
                      {data.domain}
                    </ListGroup.Item>
                  ))}
                </ListGroup>
              </Col>
              <Col md={8}>
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
