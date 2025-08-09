const noteFrequencies = {
      'C': 261.63,
      'D': 293.66,
      'E': 329.63,
      'F': 349.23,
      'G': 392.00,
      'A': 440.00,
      'B': 493.88
    };

    let targetNote = '';

    function playTone(freq, duration = 0.6) {
      const context = new (window.AudioContext || window.webkitAudioContext)();
      const oscillator = context.createOscillator();
      const gainNode = context.createGain();

      oscillator.type = 'sine';
      oscillator.frequency.value = freq;
      oscillator.connect(gainNode);
      gainNode.connect(context.destination);

      oscillator.start();
      oscillator.stop(context.currentTime + duration);
    }

    function playTargetNote() {
      const notes = Object.keys(noteFrequencies);
      targetNote = notes[Math.floor(Math.random() * notes.length)];
      playTone(noteFrequencies[targetNote]);
      document.getElementById('status').textContent = 'Playing a note... Guess which one it is!';
      document.getElementById('status').style.color = 'black';
    }

    function guessNote(note) {
      if (!targetNote) {
        document.getElementById('status').textContent = 'Please play a note first!';
        document.getElementById('status').style.color = 'orange';
        return;
      }

      if (note === targetNote) {
        document.getElementById('status').textContent = '🎉 Correct! Great ear!';
        document.getElementById('status').style.color = 'green';
      } else {
        document.getElementById('status').textContent = '❌ Wrong. Try again!';
        document.getElementById('status').style.color = 'red';
      }
    }