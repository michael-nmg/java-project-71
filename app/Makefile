.PHONY: build

build:
	@./gradlew build

checkstyle:
	@./gradlew checkstyleMain
	@./gradlew checkstyleTest

example:
	@echo "First file:"
	@cat src/test/resources/file1.json
	@echo ""
	@echo "Second file:"
	@cat src/test/resources/file2.json
	@echo ""
	@echo "Differences:"
	@./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

help:
	@./build/install/app/bin/app --help

install-dist:
	@./gradlew installDist

rebuild:
	@./gradlew clean
	@./gradlew build
	@./gradlew installDist
	@clear

report:
	@./gradlew jacocoTestReport

run-dist:
	@./build/install/app/bin/app

version:
	@./build/install/app/bin/app --version
