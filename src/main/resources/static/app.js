function LoginHandler(e) {
    e.preventDefault();

    console.log("button clicked");

    fetch("/login", {
        method: "POST"
    });
}

function GetAppointmentPreview() {
    fetch("/")
}

document.addEventListener('DOMContentLoaded', function() {
    const dateInput = document.getElementById('date');

    date.addEventListener('change', function() {
        const selectedDate = new Date(this.value);
        const currentDate = new Date();

        if (selectedDate < currentDate) {
            alert("Can't enter a previous date")
            this.value = ''; // Clear the input field if the date is in the past
        } else {
        }
    });
});
