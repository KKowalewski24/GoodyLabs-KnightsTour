import os
import pathlib
import platform
import subprocess

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
        subprocess.call("mvnw.cmd clean spring-boot:run", shell=True)
    elif platform.system().lower() == "linux":
        subprocess.call("./mvnw clean spring-boot:run", shell=True)


def run_frontend():
    go_to_selected_directory(FRONTEND)
    subprocess.call("yarn start", shell=True)


def main():
    run_backend()
    run_frontend()

    print("------------------------------------------------------------------------")
    print("FINISHED")
    print("------------------------------------------------------------------------")


if __name__ == "__main__":
    main()
