import os
import pathlib
import platform
import sys

BACKEND = "backend"
FRONTEND = "frontend"


# ----------------------------------------------------------------------------- #
def go_to_selected_directory(directory_name):
    script_directory = pathlib.Path(os.getcwd())
    os.chdir(script_directory.parent)
    os.chdir(directory_name)


def run_backend():
    go_to_selected_directory(BACKEND)
    if platform.system().lower() == "windows":
        os.system("start cmd /c mvnw.cmd clean spring-boot:run")


def build_fronted():
    go_to_selected_directory(FRONTEND)
    if platform.system().lower() == "windows":
        os.system("start cmd /c yarn install")


def run_frontend():
    go_to_selected_directory(FRONTEND)
    if platform.system().lower() == "windows":
        os.system("start cmd /c yarn start")


# ----------------------------------------------------------------------------- #
def main():
    if len(sys.argv) > 1 and (sys.argv[1] == "build" or sys.argv[1] == "-b"):
        build_fronted()
    elif len(sys.argv) > 1 and (sys.argv[1] == "run" or sys.argv[1] == "-r"):
        run_backend()
        run_frontend()

    print("------------------------------------------------------------------------")
    print("FINISHED")
    print("------------------------------------------------------------------------")


if __name__ == "__main__":
    main()
