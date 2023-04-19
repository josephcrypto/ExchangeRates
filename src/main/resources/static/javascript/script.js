const form = document.querySelector('form');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const formData = new FormData(form);
    const body = {
        currencyFrom: formData.get('currencyFrom'),
        currencyTo: formData.get('currencyTo'),
        rate: formData.get('rate')
    };

    try {
        const response = await fetch('/api/exchange-rates', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        window.location.href = '/exchange-rates';
    } catch (e) {
        console.error('Error:', e);
    }
});
