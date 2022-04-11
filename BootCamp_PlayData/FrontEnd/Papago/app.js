const inputTextEl = document.getElementById('input-text');
const outputTextEl = document.getElementById('output-text');
const toggles = document.getElementsByClassName('toggle');

function focusFunction(event) {
    outputTextEl.textContent = inputTextEl.value;
}



inputTextEl.addEventListener('keydown',focusFunction);
inputTextEl.addEventListener('keyup',focusFunction);