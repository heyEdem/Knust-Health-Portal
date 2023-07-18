function LoginHandler(e) {
    e.preventDefault();

    console.log("button clicked");

    fetch("/login", {
        method: "POST"
    });
}