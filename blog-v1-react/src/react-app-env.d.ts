/// <reference types="react-scripts" />

// Add the path polyfill
declare module 'path' {
    const sep: string;
    const delimiter: string;
    export { sep, delimiter };
    export function normalize(p: string): string;
    export function join(...paths: string[]): string;
    export function resolve(...paths: string[]): string;
    export function isAbsolute(p: string): boolean;
    export function relative(from: string, to: string): string;
    export function dirname(p: string): string;
    export function basename(p: string, ext?: string): string;
    export function extname(p: string): string;
  }
  