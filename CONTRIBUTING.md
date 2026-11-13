# Contributing

Thank you for helping improve this educational microservices project.

## Before opening a change

- Read the README and the relevant service documentation.
- Keep the existing service boundaries and dependency versions unless a change is necessary.
- Never commit JWT secrets, passwords, `.env`, tokens, or private configuration.
- Keep documentation aligned with verified source behavior.

## Validation

Run the Maven Wrapper from the module you changed:

```powershell
.\mvnw.cmd test
```

The current environment has a known Surefire lifecycle limitation; report the actual command result rather than assuming a green test suite. For documentation-only changes, validate Markdown links, JSON syntax, and examples.

## Pull requests

Describe:

- What changed and why.
- Which module or documentation area is affected.
- Commands run and their results.
- Any environment-related blockers.

Keep commits focused and avoid unrelated formatting or dependency changes.
