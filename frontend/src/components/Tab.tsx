import { ReactNode, useState } from 'react';
import classNames from 'classnames';

type tabType = {
    readonly title: string;
    readonly comp: ReactNode;
}

type props = {
    readonly tabs: readonly tabType[];
}

export function Tab({ tabs }: props) {
    const [active, setActive] = useState(tabs[0].title);
    const current = tabs.find(tab => tab.title === active);

    return (
        <>
            <div className='flex text-sm font-medium border-gray-100 overflow-x-auto overflow-y-hidden flex-shrink-0'>
                {tabs.map(({ title }) => (
                    <div
                        key={title}
                        className={classNames(
                            'p-4 -mb-px border-b cursor-pointer',
                            'text-cyan-500',
                            title === active ? 'border-current' : 'border-transparent',
                        )}
                        onClick={() => setActive(title)}
                    >
                        {title}
                    </div>
                ))}
            </div>
            {current ? current.comp : null}
        </>
    );
}
