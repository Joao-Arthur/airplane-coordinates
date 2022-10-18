import { createRoot } from 'react-dom/client';
import init, { scalonate } from 'backend';
import './index.css';
import { App } from './App';

init().then(() => {
    console.log(
        scalonate({
            point: {
                x: '1.0',
                y: '2.0',
            },
            factor: {
                x: '1.111111111111111111111111111111111111111111111111111111111111',
                y: '1.111111111111111111111111111111111111111111111111111111111111',
            },
        }),
    );
});

// eslint-disable-next-line @typescript-eslint/no-non-null-assertion
const container = document.getElementById('root')!;
const root = createRoot(container);
root.render(<App />);
