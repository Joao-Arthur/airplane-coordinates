import classNames from 'classnames';
import { ReactNode, FormEvent } from 'react';

type props = {
    children: ReactNode;
    name: string;
    onSubmit: (e: FormEvent<HTMLFormElement>) => void;
}

export function Form({ children, name, onSubmit }: props) {
    return (
        <form
            className={classNames(
                'rounded',
                'border-2 border-gray-300 border-solid p-2 ',
                'my-8',
            )}
            onSubmit={onSubmit}
        >
            <h1 className={classNames(
                'font-medium px-2',
                'dark:bg-dark-light bg-white duration-500',
                'text-gray-500 transition-colors',
                'inline-block relative -top-6',
            )}>{name}</h1>
            {children}
        </form>
    );
}
