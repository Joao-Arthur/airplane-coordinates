module.exports = {
    mode: 'jit',
    purge: ['./src/**/*.tsx'],
    darkMode: 'class',
    theme: {
        extend: {
            colors: {
                transparent: 'transparent',
                current: 'currentColor',
                primary: {
                    lighter: '#a1e9ff',
                    light: ' #6ab7ff',
                    DEFAULT: '#1e88e5',
                    dark: '#005cb2',
                    darker: '#003482',
                },
                block: 'rgba(0, 0, 0, 0.1)',
                pastel: {
                    gray: '#f5f5f5',
                },
                dark: {
                    light: '#191919',
                    DEFAULT: '#0d0d0d',
                },
            },
            flex: {
                '0-auto': '0 0 auto',
                0: '0 1 0%',
            },
            margin: {
                '-100': '-100%',
            },
            width: {
                '1/10': '10%',
                100: '400px',
                120: '500px',
            },
            maxWidth: {
                '4/5': '80%',
            },
        },
    },
    variants: {
        extend: {
            backgroundColor: ['active'],
            border: ['active'],
            borderColor: ['active'],
            textColor: ['active'],
            fontSize: ['active'],
        },
    },
    plugins: [require('@tailwindcss/forms')],
};
