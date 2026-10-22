import {useState} from "react";
import styles from "./DropDownMenu.module.css";
import Gear from "../../../assets/dropdownMenu/gear.svg";
import House from "../../../assets/dropdownMenu/house.svg";
import Leaf from "../../../assets/dropdownMenu/leaf.svg";
import SignOut from "../../../assets/dropdownMenu/sign-out.svg";

function DropdownMenu() {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <div className={styles.dropdownMenuContainer}>
            {isOpen && (
                <ul className={styles.dropdownMenuList}>
                    <li className={styles.dropdownMenuItem}>
                        <img src={House} alt="Home" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>Dashboard</span>
                    </li>
                    <li className={styles.dropdownMenuItem}>
                        <img src={Leaf} alt="Environment" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>My Sensors</span>
                    </li>
                    <li className={styles.dropdownMenuItem} onClick={() => setIsOpen(!isOpen)}>
                        <img src={Gear} alt="Settings" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>Settings</span>
                    </li>
                    <li className={styles.dropdownMenuItem}>
                        <img src={SignOut} alt="Sign Out" className={styles.dropdownMenuIcon} />
                        <span className={styles.dropdownMenuText}>Sign Out</span>
                    </li>
                </ul>
            )}
        </div>
    )
}
export default DropdownMenu;