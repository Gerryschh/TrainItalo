
function handleSubmit() {
	var form = document.getElementById('registration-form');

  const name = form.elements.name.value;
  const email = form.elements.email.value;
  const password = form.elements.password.value;

  // Eseguire i controlli qui
  if (name.length < 4) {
    alert("Il nome deve essere lungo almeno 3 caratteri");
    return false;
  }

  if (!(/^\w+([.-]?\w+)@\w+([.-]?\w+)(.\w{2,3})+$/.test(email))){
       alert("L'indirizzo email che hai inserito non e' valido");
       return false;
    }

  if (password.length < 8) {
    alert("La password deve essere lunga almeno 8 caratteri");
    return false;
  }

  // Se i controlli sono superati, inviare i dati al server
  const data = { name, email, password };
  fetch('/register', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then((response) => response.json())
    .then((result) => {
      alert("Ce l'hai fatta!");
    });
}