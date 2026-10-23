import styles from "./DropDownMenu.module.css";
import Gear from "../../../assets/dropdownMenu/gear.svg";
import House from "../../../assets/dropdownMenu/house.svg";
import Leaf from "../../../assets/dropdownMenu/leaf.svg";
import SignOut from "../../../assets/dropdownMenu/sign-out.svg";

type DropdownMenuProps = {
    isOpen: boolean;
};

function DropdownMenu({ isOpen }: DropdownMenuProps) {
    if (!isOpen) return null;

    return (
        <div className={styles.dropdownMenuContainer}>
            <ul className={styles.dropdownMenuList}>
                <li className={styles.dropdownMenuItem}>
                    <a href="/dashoard" className={styles.dropdownMenuLink}>
                        <img src={House} alt="Home" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>Dashboard</span>
                    </a>
                </li>
                <li className={styles.dropdownMenuItem}>
                    <a href="/sensors" className={styles.dropdownMenuLink}>
                        <img src={Leaf} alt="Environment" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>My Sensors</span>
                    </a>
                </li>
                <li className={styles.dropdownMenuItem}>
                    <a href="/settings" className={styles.dropdownMenuLink}>
                        <img src={Gear} alt="Settings" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>Settings</span>
                    </a>
                </li>
                <li className={styles.dropdownMenuItem}>
                    <a href="/login" className={styles.dropdownMenuLink}>
                        <img src={SignOut} alt="Sign Out" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>Sign Out</span>
                    </a>
                </li>
            </ul>
        </div>
    );
}

export default DropdownMenu;