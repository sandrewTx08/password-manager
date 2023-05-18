"use client";

import { Context, Data } from "@/contexts/Logins";
import { Tab, Row, Col, ListGroup, Form, InputGroup } from "react-bootstrap";
import { useDebounce } from "use-debounce";
import React, { useState, useEffect } from "react";
import {
  BsEye,
  BsEyeFill,
  BsFillClipboard2Fill,
  BsFillPencilFill,
  BsFillTrash3Fill,
  BsGlobe2,
} from "react-icons/bs";

function CreateLogin({ data }: React.PropsWithChildren<{ data: Data }>) {
  return <></>;
}

function LoginTabPane({ data }: React.PropsWithChildren<{ data: Data }>) {
  const [loginData, loginSet] = useState(data);
  const [loginDataInput] = useDebounce(loginData, 1000);
  const [editing, editingSet] = useState(true);
  const [showPasswordInput, showPasswordInputSet] = useState(false);

  useEffect(() => {
    fetch(`/login/${loginDataInput._id}`, {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      method: "PATCH",
      body: JSON.stringify(loginDataInput),
    });
  }, [loginDataInput]);

  function onChange(event: React.ChangeEvent) {
    loginSet((value) => {
      // @ts-ignore
      value[event.target.name] = event.target.value;
      return { ...value };
    });
  }

  return (
    <Tab.Pane eventKey={data._id}>
      <div className="d-flex justify-content-between ellipsis mb-4">
        <div className="d-flex gap-3">
          <BsGlobe2 className="fs-1 ml-1" />
          <h2>
            <b>{loginData.domain}</b>
          </h2>
        </div>

        <div className="d-flex gap-3">
          <BsFillPencilFill
            className="p-2 fs-1"
            onClick={() => editingSet((value) => !value)}
          />
          <BsFillTrash3Fill className="p-2 fs-1" />
        </div>
      </div>

      <div>
        <InputGroup>
          <Form.Control
            size="sm"
            name="username"
            type="text"
            disabled={editing}
            className="mb-2"
            placeholder="Username"
            value={loginData.username}
            onChange={onChange}
          />
          <BsFillClipboard2Fill
            className="m-2"
            onClick={() => navigator.clipboard.writeText(loginData.username)}
          />
        </InputGroup>

        <InputGroup>
          <Form.Control
            size="sm"
            name="password"
            type={showPasswordInput ? "text" : "password"}
            disabled={editing}
            className="mb-2"
            placeholder="Password"
            value={loginData.password}
            onChange={onChange}
          />

          {showPasswordInput ? (
            <BsEye
              className="fs-4 m-2"
              onClick={() => showPasswordInputSet((value) => !value)}
            />
          ) : (
            <BsEyeFill
              className="fs-4 m-2"
              onClick={() => showPasswordInputSet((value) => !value)}
            />
          )}

          <BsFillClipboard2Fill
            className="m-2"
            onClick={() => navigator.clipboard.writeText(loginData.password)}
          />
        </InputGroup>
      </div>
    </Tab.Pane>
  );
}

export default function Page() {
  return (
    <Context.Consumer>
      {([state]) =>
        state ? (
          <Tab.Container
            id="list-group-tabs-example"
            defaultActiveKey={state[0]._id}
          >
            <Row className="container-fluid d-flex justify-content-between">
              <Col xs={4}>
                <ListGroup>
                  {state.map((data) => (
                    <ListGroup.Item
                      className="text-truncate"
                      key={data._id}
                      eventKey={data._id}
                      action
                    >
                      {data.domain}
                    </ListGroup.Item>
                  ))}
                </ListGroup>
              </Col>
              <Col xs={8}>
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
