import { StrictMode } from 'react';
import './index.css';
import { AirplaneProvider } from './integrations/airplane/AirplaneProvider';
import { RadarProvider } from './integrations/radar/RadarProvider';
import { MainPage } from './pages/MainPage/MainPage';

export function App() {
    return (
        <StrictMode>
            <AirplaneProvider>
                <RadarProvider>
                    <MainPage />
                </RadarProvider>
            </AirplaneProvider>
        </StrictMode>
    );
}
