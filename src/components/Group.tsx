import { ReactNode } from 'react';

type props = {
    children: ReactNode[];
}

export function Group({ children }: props) {
    return (
        <div className='flex'>
            {children}
        </div>
    );
}
