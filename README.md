### Project "Difference Calculator"

#### Tests and linter status:
[![Actions Status](https://github.com/michael-nmg/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/michael-nmg/java-project-71/actions) [![Java CI Status](https://github.com/michael-nmg/java-project-71/workflows/Java%20CI/badge.svg)](https://github.com/michael-nmg/java-project-71/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/6b5d65eec3cfa02647aa/maintainability)](https://codeclimate.com/github/michael-nmg/java-project-71/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/6b5d65eec3cfa02647aa/test_coverage)](https://codeclimate.com/github/michael-nmg/java-project-71/test_coverage)

#### Description:

- Console utility compares two files formats: `json` or `yaml`.
- Result is output in following formats: `stylish` (default), `plain text`, `json`.
- Project uses picocli &nbsp;[![picocli](https://img.shields.io/badge/picocli-4.7.5-green.svg)](https://github.com/remkop/picocli)


#### Command line format:

```
gendiff [-hV] [-f=<formatName>] <filepath1> <filepath2>
```

#### Parameters:

```
Usage: gendiff [-hV] [-f=format] filepath1 filepath2
    filepath1         path to first file
    filepath2         path to second file
    -f, --format=format   output format [default: stylish]
    -h, --help            Show this help message and exit.
    -V, --version         Print version information and exit.
```

#### Help and version output:
[![asciicast](https://asciinema.org/a/4t1WXWcNwKb0wJl7FqcFnCCq2.svg)](https://asciinema.org/a/4t1WXWcNwKb0wJl7FqcFnCCq2)

#### Output format `stylish` (default):
[![asciicast](https://asciinema.org/a/e7jrjY623brcKJ0CTaJrAHRPF.svg)](https://asciinema.org/a/e7jrjY623brcKJ0CTaJrAHRPF)

#### Output format `plain text`:
[![asciicast](https://asciinema.org/a/k9ZVVtl2wMPNDjDtMiU3H1mlI.svg)](https://asciinema.org/a/k9ZVVtl2wMPNDjDtMiU3H1mlI)

#### Output format `json`:
[![asciicast](https://asciinema.org/a/nSEgduBnqmlAQUt2uGBUK4QGo.svg)](https://asciinema.org/a/nSEgduBnqmlAQUt2uGBUK4QGo)

