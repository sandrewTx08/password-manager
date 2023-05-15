"use client";

import { Context } from "@/contexts/User";

export default function Home() {
  return (
    <h1>
      <Context.Consumer>
        {(state) => <>{JSON.stringify(state)}</>}
      </Context.Consumer>
    </h1>
  );
}
