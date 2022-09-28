import { StrictMode } from 'react';
import './index.css';
import { AirplaneProvider } from './integrations/airplane/AirplaneProvider';
import { MainPage } from './pages/MainPage/MainPage';

export function App() {
    return (
        <StrictMode>
            <AirplaneProvider>
                <MainPage />
            </AirplaneProvider>
        </StrictMode>
    );
}
