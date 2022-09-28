import { useState } from 'react';
import { useDidMount } from 'rooks';
import { MainLayout } from './MainLayout';

export function MainPage() {
    const [height, setHeight] = useState(window.innerHeight);

    function resize() {
        setHeight(window.innerHeight);
    }

    useDidMount(() => {
        window.addEventListener('resize', resize);
        return () => window.removeEventListener('resize', resize);
    });

    return (
        <div
            style={{ height }}
            className='flex flex-col dark:bg-dark-light transition-colors duration-500 overflow-auto'
        >
            <main className='flex h-full'>
                <MainLayout />
            </main>
        </div>
    )
}