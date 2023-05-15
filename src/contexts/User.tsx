"use client";

import { createContext } from "react";

type Value = any;

type State = [Value, React.Dispatch<Value>];

export const Context = createContext<State>(null);

export default function Provider({
  children,
  state,
}: React.PropsWithChildren<{ state: State }>) {
  return <Context.Provider value={state}>{children}</Context.Provider>;
}
