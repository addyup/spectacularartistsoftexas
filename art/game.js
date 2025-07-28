const lanes = document.querySelectorAll('.lane');
let score = 0;
const scoreDisplay = document.getElementById('score');

// Generate random notes
function createNote() {
  const laneIndex = Math.floor(Math.random() * lanes.length);
  const lane = lanes[laneIndex];

  const note = document.createElement('div');
  note.classList.add('note');
  lane.appendChild(note);

  let pos = 0;
  const interval = setInterval(() => {
    pos += 2;
    note.style.top = pos + 'px';

    if (pos > 380) {
      clearInterval(interval);
      lane.removeChild(note);
    }
  }, 20);
}

// Play sound (simple beep)
function playSound(freq = 261.6) {
  const audioCtx = new (window.AudioContext || window.webkitAudioContext)();
  const oscillator = audioCtx.createOscillator();
  const gainNode = audioCtx.createGain();

  oscillator.connect(gainNode);
  gainNode.connect(audioCtx.destination);
  oscillator.type = 'sine';
  oscillator.frequency.value = freq;
  oscillator.start();
  gainNode.gain.exponentialRampToValueAtTime(0.0001, audioCtx.currentTime + 0.5);
  oscillator.stop(audioCtx.currentTime + 0.5);
}

// Key press event
window.addEventListener('keydown', e => {
  const key = e.keyCode;
  const lane = document.querySelector(`.lane[data-key="${key}"]`);
  if (!lane) return;

  const note = lane.querySelector('.note');
  if (note) {
    const top = parseInt(note.style.top);
    if (top > 340 && top < 390) {
      score += 10;
      playSound();
      lane.removeChild(note);
    }
  }
  scoreDisplay.textContent = `Score: ${score}`;
});

// Generate notes every second
setInterval(createNote, 1000);

// Mobile button support
const buttons = document.querySelectorAll('#mobile-controls button');

buttons.forEach(button => {
  button.addEventListener('click', () => {
    const key = parseInt(button.getAttribute('data-key'));
    handleNoteHit(key);
  });
});

// Shared note-hit logic
function handleNoteHit(key) {
  const lane = document.querySelector(`.lane[data-key="${key}"]`);
  if (!lane) return;

  const note = lane.querySelector('.note');
  if (note) {
    const top = parseInt(note.style.top);
    if (top > 340 && top < 390) {
      score += 10;
      playSound();
      lane.removeChild(note);
    }
  }
  scoreDisplay.textContent = `Score: ${score}`;
}

// Update keyboard event to use shared function
window.addEventListener('keydown', e => {
  handleNoteHit(e.keyCode);
});
