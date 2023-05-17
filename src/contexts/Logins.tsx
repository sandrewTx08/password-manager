"use client";

import { createContext } from "react";

type Data = any;

type State = [Data, React.Dispatch<Data>];

export const Context = createContext<State>([null, null]);

export default function Provider({
  children,
  state,
}: React.PropsWithChildren<{ state: State }>) {
  return <Context.Provider value={state}>{children}</Context.Provider>;
}
