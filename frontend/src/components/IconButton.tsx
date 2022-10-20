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
                    'w-full py-2 text-sm text-center focus:outline-none rounded border-2 flex justify-center',
                    'text-white hover:text-cyan-500 active: active:text-cyan-500',
                    'bg-cyan-500 hover:bg-cyan-100 active:bg-cyan-100',
                    'border-cyan-500 hover:border-cyan-500 active:border-cyan-500',
                )
            }
            onClick={onClick}
        >
            {children}
        </button>
    );
}
