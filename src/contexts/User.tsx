"use client";

import { createContext } from "react";

export type Data = any;

export type State = [Data, React.Dispatch<Data>];

export const Context = createContext<State>([null, null]);

export default function Provider({
  children,
  state,
}: React.PropsWithChildren<{ state: State }>) {
  return <Context.Provider value={state}>{children}</Context.Provider>;
}
