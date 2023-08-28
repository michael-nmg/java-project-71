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
