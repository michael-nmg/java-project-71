checkstyle:
	@./gradlew checkstyleMain

install-dist:
	@./gradlew installDist

rebuild:
	@./gradlew clean
	@./gradlew build
	@./gradlew installDist
	@clear

run-dist:
	@./build/install/app/bin/app

version:
	@./build/install/app/bin/app --version

help:
	@./build/install/app/bin/app --help

example:
	@echo "First file:"
	@cat src/test/resources/file1.json
	@echo ""
	@echo "Second file:"
	@cat src/test/resources/file2.json
	@echo ""
	@echo "Differences:"
	@./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

