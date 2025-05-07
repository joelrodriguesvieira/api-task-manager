import type { Config } from "jest";

const config: Config = {
  preset: "ts-jest",
  testEnvironment: "node",
  testMatch: ["/tests//*.test.ts"],
  moduleFileExtensions: ["ts", "js", "json"],
  roots: ["<rootDir>/tests"],
  transform: {
    "^.+\.ts?$": "ts-jest",
  },
};

export default config;
