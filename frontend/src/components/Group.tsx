import { ReactNode } from 'react';

type props = {
    readonly children: readonly ReactNode[];
}

export function Group({ children }: props) {
    return (
        <div className='flex'>
            {children}
        </div>
    );
}
