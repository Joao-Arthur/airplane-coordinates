import { ReactNode } from 'react';

type props = {
    readonly children: ReactNode[];
}

export function Group({ children }: props) {
    return (
        <div className='flex'>
            {children}
        </div>
    );
}
