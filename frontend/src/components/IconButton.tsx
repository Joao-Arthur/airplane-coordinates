import classNames from 'classnames';
import { ReactNode } from 'react';

type props = {
    readonly children: ReactNode;
    readonly onClick?: () => void;
}

export function IconButton({ onClick, children }: props) {
    return (
        <button
            className={
                classNames(
                    'w-8 py-2 text-sm text-center focus:outline-none rounded border-2 flex justify-center',
                    'text-white hover:text-cyan-500 active:text-cyan-500',
                    'bg-cyan-500 hover:bg-cyan-300 active:bg-cyan-300',
                    'border-cyan-500 hover:border-cyan-500 active:border-cyan-500',
                )
            }
            onClick={onClick}
        >
            {children}
        </button>
    );
}
